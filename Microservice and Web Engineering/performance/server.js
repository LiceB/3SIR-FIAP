const express = require('express')
const app = express()
const redis = require('redis')
const host = "localhost"
const port = 6379
const clientRedis = redis.createClient({ host: host, port: port });

app.use(express.json())

let clientes = [
    {
        "nome": "Alice Bianchi"
    },
    {
        "nome": "Adriana Bianchi"
    }
]

//Vamos simular um problema
const getAllClients = async () => {
    const time = Math.random() * 8000
    return new Promise((resolve) => {
        setTimeout(() => {
            resolve(clientes)
        }, time)
    })
}

app.post("/", async (req, res) => {
    //salvar informações
    //console.log("Salvando infos ", req.body)
    clientes.push(req.body)

    //removendo o cache
    await clientRedis.del("clientes")
    res.status(200).send("Removido com sucesso")
})

app.get("/", async (req, res) => {
    //clientRedis.set("nome", "Alice")
    const chave = "clientes"

    try {
        const clientFromCache = await clientRedis.get(chave)
        if (clientFromCache) {
            const objetoCliente = JSON.parse(clientFromCache)
            res.status(200).send(objetoCliente)
            return;
        }

        const clients = await getAllClients()

        //configurar o cache
        await clientRedis.set(chave, JSON.stringify(clients), { EX: 60 })

        res.status(200).send(clients)
    } catch (e) {
        res.status(500).send("Ocorreu um erro")
    }

})

const startup = async () => {
    //Connectar o redis
    await clientRedis.connect()

    app.listen(3000, () => {
        console.log("Server is running on port 3000")
    })
}

startup()