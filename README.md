# poc-spring-vue3-keycloak
SPAとkeycloak連携検証用

# 環境構築(Mac)
## node(v14.17.0) インストール(nodebrewでバージョン切り替えられるようにインストール)
### 参考 https://qiita.com/7110/items/efe0be1be11bed1db143

## java(openjdk 11)インストール
### 参考　https://help.rview.com/hc/ja/articles/360018669493--MacOS-OpenJDK%E3%82%A4%E3%83%B3%E3%82%B9%E3%83%88%E3%83%BC%E3%83%AB%E6%96%B9%E6%B3%95

## Dockerインストール
### 参考　https://qiita.com/kurkuru/items/127fa99ef5b2f0288b81

## mavenインストール
### 参考　https://salumarine.com/installing-maven-on-mac/

# ローカルでアプリ起動
## keycloak(認可サーバ)立ち上げ 8080ポート
`docker run -p 8080:8080 -e KEYCLOAK_USER=admin -e KEYCLOAK_PASSWORD=admin quay.io/keycloak/keycloak:15.0.2`
### 立ち上げたらadmin/adminでログインしてimportからkeycloak/realm-export.jsonをインポート
### ユーザbobを作成
#### 参考　https://baubaubau.hatenablog.com/entry/2021/02/12/201803

## フロントエンド立ち上げ 3000ポート
`cd frontend`
`npm run dev`

## バックエンド立ち上げ 8081ポート
`cd backend`
`mvn spring-boot:run`

## localhost:3000にアクセス
### bobでログインするとフロントがkeycloakと連携して認証できる。
### 登録画面の登録ボタンを押すとアクセストークンをセットしてリソースサーバ(spring)のhelloエンドポイントをコールできる
### 一先ず次はフロントで登録フォームを用意して、バックエンドにはkeycloakの登録APIを叩いてユーザ登録機能を作成し、連携できるようにする
