住所とISBNを入力して蔵書がある図書館を表示
書名を入れた場合は、一致する一覧が表示されるため、ダブルクリックして選択
(※書名検索は取得件数の制限をかけているため、検索文字数を増やさないと表示されないこともある)

プロキシ環境の場合は
proxy.txtのファイルを作成
内容は以下(認証がない場合は、PROXY_USER・PROXY_PASSは不要)
PROXY_URL:172.16.1.9
PROXY_PORT:8080
PROXY_USER:XXXX
PROXY_PASS:XXXX



■使用しているグローバルAPI
住所から座標取得に使用
≪Geocoding - 住所から緯度経度を検索≫
https://www.geocoding.jp/

書名からISBN取得に使用
≪国立国会図書館サーチ（NDL Search）≫
https://iss.ndl.go.jp/

ISBNと座標から図書館蔵書検索に使用
≪カーリル | 日本最大の図書館蔵書検索サイト≫
https://calil.jp/
