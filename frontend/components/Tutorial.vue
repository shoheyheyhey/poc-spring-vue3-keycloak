<!-- Please remove this file from your project -->
<template>
  <div class="relative flex items-top justify-center min-h-screen bg-gray-100 sm:items-center sm:pt-0">
    <div class="max-w-4xl mx-auto sm:px-6 lg:px-8">
      <h2>ログイン状態:{{ $auth.loggedIn }}</h2>
      <div>
        <nav>
          <nuxt-link to="/userRegist">ユーザ登録</nuxt-link>
        </nav>
        <nav>
          <button @click="$auth.logout()">ログアウト</button>
        </nav>
      </div>
    </div>
  </div>
</template>
