const express = require('express')
const mysql = require('mysql2');

const connection = mysql.createConnection({
    host: "localhost",
    user: "root",
    password: "123",
    database: "fiap"
})

connection.connect((err) => {
    if (err) {
        console.log('erro ao conectar', err)
        return
    }
    console.log(`Running on http://${host}:${port}`)
})

const port = 4000
const host = '0.0.0.0'

const app = express()

app.get('/', (req, res) => {
    const query = "select id, name, price from products;"
    connection.query(query, (error, results, fields) => {
        if(error) {
            console.error("Erro na query", err)
            return
        }

        const products = results.map(item => ({ id: item.id, nome: item.name, preco: item.price }))
        console.error('Erro na query', error)

        res.status(200).send(products)
    })


    //res.status(200).send("Executando localmente...")
})

app.listen(port, host)