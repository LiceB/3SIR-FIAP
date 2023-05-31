import 'package:flutter/material.dart';

void main() {
  runApp(MaterialApp(
    debugShowCheckedModeBanner: false,
    home: MyApp(),
  ));
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      drawer: Drawer(
        child: Column(
          children: [
            UserAccountsDrawerHeader(
                currentAccountPicture: CircleAvatar(
                  backgroundImage: AssetImage('images/avatar.png'),
                  radius: 50,
                ),
                accountName: Text('Bella'),
                accountEmail: Text('bella@gmail.com')),
            ListTile(
              leading: Icon(Icons.inbox),
              title: Text('Primary'),
            ),
            ListTile(
              leading: Icon(Icons.people),
              title: Text('Social'),
            ),
            ListTile(
              leading: Icon(Icons.local_offer),
              title: Text('Promotions'),
            )
          ],
        ),
      ),
      appBar: AppBar(
        title: Text('Checkpoint 01'),
      ),
      body: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          Text('Alice Bianchi',
              style: TextStyle(fontWeight: FontWeight.bold, fontSize: 30)),
          Row(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Icon(Icons.facebook, color: Colors.blue),
              Icon(Icons.phone, color: Colors.green),
              Icon(Icons.email, color: Colors.red),
            ],
          ),
        ],
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: null,
        child: Icon(Icons.chat),
        backgroundColor: Colors.green,
      ),
    );
  }
}
