export default {
  // Global page headers: https://go.nuxtjs.dev/config-head
  head: {
    title: 'frontend',
    htmlAttrs: {
      lang: 'en'
    },
    meta: [
      { charset: 'utf-8' },
      { name: 'viewport', content: 'width=device-width, initial-scale=1' },
      { hid: 'description', name: 'description', content: '' },
      { name: 'format-detection', content: 'telephone=no' }
    ],
    link: [
      { rel: 'icon', type: 'image/x-icon', href: '/favicon.ico' }
    ]
  },

  // Global CSS: https://go.nuxtjs.dev/config-css
  css: [
  ],

  // Plugins to run before rendering page: https://go.nuxtjs.dev/config-plugins
  plugins: [
    '@/plugins/axios'
  ],

  // Auto import components: https://go.nuxtjs.dev/config-components
  components: true,

  // Modules for dev and build (recommended): https://go.nuxtjs.dev/config-modules
  buildModules: [
    // https://go.nuxtjs.dev/typescript
    '@nuxt/typescript-build',
  ],

  // Modules: https://go.nuxtjs.dev/config-modules
  modules: [
    // https://go.nuxtjs.dev/axios
    '@nuxtjs/axios',
    '@nuxtjs/auth-next',
  ],

  // Axios module configuration: https://go.nuxtjs.dev/config-axios
  axios: {
    baseURL: 'http://localhost:8081/'
  },

  // ログイン、ログアウト
  auth: {
    redirect: {
      login: '/login',
      logout: '/logout',
      callback: '/callback',
      home: '/',
    },
    strategies: {
      keycloak: {
        scheme: 'oauth2',
        grantType: 'authorization_code',
        endpoints: {
          authorization:
            'http://localhost:8080/auth/realms/DocumentService/protocol/openid-connect/auth',
          token:
            'http://localhost:8080/auth/realms/DocumentService/protocol/openid-connect/token',
          logout:
            'http://localhost:8080/auth/realms/DocumentService/protocol/openid-connect/logout?redirect_uri=http://localhost:3000',
        },
        token: {
          property: 'access_token',
          type: 'Bearer',
          maxAge: 60 * 2 // アクセストークンのライフスパン設定
        },
        refreshToken: {
          property: 'refresh_token',
          maxAge: 60 * 3 // リフレッシュトークンのライフスパン設定
        },

        responseType: 'code',
        clientId: 'account',
        scope: ['openid'],
        codeChallengeMethod: 'S256'
      },
    },
  },
  router: {
    middleware: ['auth'],
  },

  // Build Configuration: https://go.nuxtjs.dev/config-build
  build: {
  }
}
