# my-health-trax-platform-admin

## Docker

### Building the docker image

```bash
yarn build && docker build -t my-health-trax-platform-admin .
```

### Running the docker image as a container

```bash
docker run --name my-health-trax-platform-admin -d -p 8080:80 my-health-trax-platform-admin:latest
```



## Project setup
```
yarn install
```

### Compiles and hot-reloads for development
```
yarn run serve
```

### Compiles and minifies for production
```
yarn run build
```

### Run your tests
```
yarn run test
```

### Lints and fixes files
```
yarn run lint
```

### Run your end-to-end tests
```
yarn run test:e2e
```

### Run your unit tests
```
yarn run test:unit
```

### Customize configuration
See [Configuration Reference](https://cli.vuejs.org/config/).
