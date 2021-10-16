# poc-spring-nuxt-keycloak
SPAとkeycloak連携検証用

# 参考URL
* https://qiita.com/mkyz08/items/62b1552fa9511fb11574
* https://baubaubau.hatenablog.com/entry/2021/02/12/201803

## dockerでkeycloak起動
`docker run -p 8080:8080 -e KEYCLOAK_USER=admin -e KEYCLOAK_PASSWORD=admin quay.io/keycloak/keycloak:15.0.2`

## keycloak設定
1. realmを「poc realm」で作成
2. clientを「poc-client」で作成(valid redirectに`http://localhost:8081/*`を入れる)
3. userを「user1」で作成
4. roleを「user」で作成
5. userにroleを紐付ける
