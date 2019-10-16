<template>
  <div>
    <div>
      <img :src="$auth.user.picture" class="h-16 w-16 rounded-full mx-auto" />
      <h2>{{ $auth.user.name }}</h2>
      <p>{{ $auth.user.email }}</p>
    </div>

    <div>
      <pre>{{ JSON.stringify($auth.user, null, 2) }}</pre>
    </div>
  </div>
</template>

<script>
export default {
  name: "UserProfile"
};
</script>
