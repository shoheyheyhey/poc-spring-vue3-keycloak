<template>
    <button @click="registUser()">ユーザ登録</button>
</template>

<script>
import axios from 'axios'
export default {
  methods: {
    registUser () {
        axios.get('http://localhost:8081/hello', {headers:{Authorization:localStorage.getItem('auth._token.keycloak')}})
        .then(function (response) {
            console.log(response.data);
        });
    }
  }
}
</script>