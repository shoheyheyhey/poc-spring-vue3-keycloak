<template>
  <div></div>
</template>

<script>
export default {
  mounted() {
    // ローカルストレージ情報削除
    localStorage.removeItem("auth._refresh_token_expiration.keycloak");
    localStorage.removeItem("auth.keycloak.pkce_state");
    localStorage.removeItem("auth._refresh_token.keycloak");
    localStorage.removeItem("auth._token.keycloak");
    localStorage.removeItem("auth._token_expiration.keycloak");
    localStorage.removeItem("auth.strategy");

    // cookie削除
    document.cookie = `auth._refresh_token_expiration=;max-age=0`;
    document.cookie = `auth.keycloak.pkce_state=;max-age=0`;
    document.cookie = `auth._refresh_token.keycloak=;max-age=0`;
    document.cookie = `auth._token.keycloak=;max-age=0`;
    document.cookie = `auth._token_expiration.keycloak=;max-age=0`;
    document.cookie = `auth.strategy=;max-age=0`;
    
    this.$auth.logout();
    


    
  },
}
</script>