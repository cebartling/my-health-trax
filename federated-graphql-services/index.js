const {ApolloGateway} = require('@apollo/gateway');
const {ApolloServer} = require('apollo-server');

const gateway = new ApolloGateway({
    serviceList: [
        {name: 'accounts', url: 'http://localhost:8080'},
    ]
});

const server = new ApolloServer({gateway, subscriptions: false});
server.listen();