<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>新規登録</title>
</head>
<body>
<h1>新規登録</h1>
<hr width="800"align="left">

<form action="/Egg/InsertUserServlet" method="post">

名前：
<input type="text" name="name">
<br><br>
性別:
<input type="radio"name="gender"value="mr">男
<input type="radio"name="gender"value="miss">女
<br><br>
都道府県：
<select name="pref">
<option value="">選択してください</option>
<option value="北海道">北海道</option>
<option value="青森県">青森県</option>
<option value="岩手県">岩手県</option>
<option value="宮城県">宮城県</option>
<option value="秋田県">秋田県</option>
<option value="山形県">山形県</option>
<option value="福島県">福島県</option>
<option value="茨城県">茨城県</option>
<option value="栃木県">栃木県</option>
<option value="群馬県">群馬県</option>
<option value="埼玉県">埼玉県</option>
<option value="千葉県">千葉県</option>
<option value="東京都" selected>東京都</option>
<option value="神奈川県">神奈川県</option>
<option value="新潟県">新潟県</option>
<option value="富山県">富山県</option>
<option value="石川県">石川県</option>
<option value="福井県">福井県</option>
<option value="山梨県">山梨県</option>
<option value="長野県">長野県</option>
<option value="岐阜県">岐阜県</option>
<option value="静岡県">静岡県</option>
<option value="愛知県">愛知県</option>
<option value="三重県">三重県</option>
<option value="滋賀県">滋賀県</option>
<option value="京都府">京都府</option>
<option value="大阪府">大阪府</option>
<option value="兵庫県">兵庫県</option>
<option value="奈良県">奈良県</option>
<option value="和歌山県">和歌山県</option>
<option value="鳥取県">鳥取県</option>
<option value="島根県">島根県</option>
<option value="岡山県">岡山県</option>
<option value="広島県">広島県</option>
<option value="山口県">山口県</option>
<option value="徳島県">徳島県</option>
<option value="香川県">香川県</option>
<option value="愛媛県">愛媛県</option>
<option value="高知県">高知県</option>
<option value="福岡県">福岡県</option>
<option value="佐賀県">佐賀県</option>
<option value="長崎県">長崎県</option>
<option value="熊本県">熊本県</option>
<option value="大分県">大分県</option>
<option value="宮崎県">宮崎県</option>
<option value="鹿児島県">鹿児島県</option>
<option value="沖縄県">沖縄県</option>
</select>
<br><br>
<script src="https://ajaxzip3.github.io/ajaxzip3.js"></script>
  <label>郵便番号(ハイフンもOK):</label>
  <input type="text" name="zip11" size="10" maxlength="8" onKeyUp="AjaxZip3.zip2addr(this,'','addr11','addr11');">
  <br><br>
  <label>都道府県と以降の住所:</label>
  <input type="text" name="addr11" size="60">
<br><br>
電話番号(ハイフン無し):<input type="text" name="tel">
<br><br>
アカウント名:<input type="text"name="account">
<br><br>

パスワード:<input type="password" name="pass">
<br><br>

パスワード（再入力）:<input type="password"name="pass1">
<br><br>
メールアドレス:<input type="text"name="mail">
<br><br>
<input type="submit"value="登録">
</form>
<p></p>
<form action="/Egg/TopServlet" method="post">
<input type="submit"value="Top画面に戻る">
</form>
</body>
</html>