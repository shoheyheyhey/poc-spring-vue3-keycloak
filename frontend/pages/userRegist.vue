<template>
    <button @click="registUser()">ユーザ登録</button>
</template>

<script>
import axios from 'axios'
export default {
  methods: {
    async registUser () {
      console.log("トークンステータス：" + JSON.stringify(this.$auth.check(true)));

      // トークン切れたらリフレッシュ
      if (!this.$auth.check(true).valid) {
        console.log("リフレッシュ" + JSON.stringify(await this.$auth.refreshTokens()));
      }
      axios.get('http://localhost:8081/hello', {headers:{Authorization:localStorage.getItem('auth._token.keycloak')}})
      .then(function (response) {
          console.log(response.data);
      });
    }
  }
}
</script>