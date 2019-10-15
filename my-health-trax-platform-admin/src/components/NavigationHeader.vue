<template>
  <div id="nav">
    <router-link to="/">Home</router-link>
    |
    <router-link to="/about">About</router-link>
    <span v-if="$auth.isAuthenticated">
      |
      <router-link to="/userProfile">
        User profile
      </router-link>
    </span>
  </div>
</template>

<script>
export default {
  name: "NavigationHeader"
};
</script>

<style scoped></style>
