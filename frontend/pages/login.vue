<template>
  <div></div>
</template>

<script>
export default {
  mounted() {
    this.$auth.loginWith('keycloak');
  },
}
</script>