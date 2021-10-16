# poc-spring-nuxt-keycloak
SPAとkeycloak連携検証用

# 参考URL
* https://qiita.com/mkyz08/items/62b1552fa9511fb11574
* https://baubaubau.hatenablog.com/entry/2021/02/12/201803

## dockerでkeycloak起動
`docker run -p 8080:8080 -e KEYCLOAK_USER=admin -e KEYCLOAK_PASSWORD=admin quay.io/keycloak/keycloak:15.0.2`

## keycloak設定
1. realmを「DocumentService」で作成
2. clientを「documentservice」で作成
3. userを「bob」で作成
4. roleを「read」で作成
5. clientにroleを紐付ける

## Spring Initializrでプロジェクト作成

## 
