<template>
  <div id="app">
    <NavigationHeader />
    <router-view />
  </div>
</template>

<script>
import NavigationHeader from "@/components/NavigationHeader";

export default {
  components: { NavigationHeader }
};
</script>

<style lang="scss">
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;

  a {
    font-weight: bold;
    color: #2c3e50;
    cursor: pointer;
    text-decoration: underline;

    &:hover {
      background-color: bisque;
    }

    &.router-link-exact-active {
      color: #42b983;

      &:hover {
        background-color: transparent;
      }
    }
  }
}
</style>
