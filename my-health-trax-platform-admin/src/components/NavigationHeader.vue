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
    |
    <span v-if="!$auth.loading">
      <!-- show login when not authenticated -->
      <a v-if="!$auth.isAuthenticated" @click="login">Sign in</a>
      <!-- show logout when authenticated -->
      <a v-if="$auth.isAuthenticated" @click="logout">Sign out</a>
    </span>
  </div>
</template>

<script>
export default {
  name: "NavigationHeader",
  methods: {
    // Log the user in
    login() {
      this.$auth.loginWithRedirect();
    },
    // Log the user out
    logout() {
      this.$auth.logout({
        returnTo: window.location.origin
      });
    }
  }
};
</script>

<style scoped></style>
