# poc-spring-vue3-keycloak
SPAとkeycloak連携検証用

# 環境構築(for Mac)
## node(v14.17.0) インストール(nodebrewでバージョン切り替えられるようにインストール)
### 参考 https://qiita.com/7110/items/efe0be1be11bed1db143

## java(openjdk 11)インストール
### 参考　https://help.rview.com/hc/ja/articles/360018669493--MacOS-OpenJDK%E3%82%A4%E3%83%B3%E3%82%B9%E3%83%88%E3%83%BC%E3%83%AB%E6%96%B9%E6%B3%95

## Dockerインストール
### 参考　https://qiita.com/kurkuru/items/127fa99ef5b2f0288b81

## mavenインストール
### 参考　https://salumarine.com/installing-maven-on-mac/



# ローカルでアプリ起動
## keycloak(認可サーバ)起動手順 8180ポート
`docker-compose up -d`

立ち上げたらlocalhost:8180へアクセス＞Administration Console＞admin/adminコンソール画面にログインできる


## フロントエンド起動 3000ポート
`cd frontend`
`npm run dev`

## バックエンド立ち上げ 8081ポート
`cd backend`
`mvn spring-boot:run`
