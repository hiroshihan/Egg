DROP TABLE if EXISTS user;
DROP TABLE if EXISTS item;

CREATE TABLE user
(
	db_user_code SERIAL PRIMARY KEY,
	db_user_name TEXT,
	db_user_post TEXT,
	db_user_email TEXT,
	db_user_gender TEXT,
	db_user_pass TEXT,
);

CREATE TABLE item
(
	db_item_code SERIAL PRIMARY KEY,
	db_item_name TEXT,
	db_item_price TEXT,
	db_item_category TEXT,
	db_item_review TEXT,
);

insert into user(db_user_name, db_user_post, db_user_email, db_user_gender, db_user_pass) values(谷本泰憲,群馬県沼田市秋塚町,yasunori85529@skve.mzz,男,yasunori1234);
insert into user(db_user_name, db_user_post, db_user_email, db_user_gender, db_user_pass) values(遠山夏海,群馬県邑楽郡板倉町大曲,natsumi82235@rexwqvja.ij,女,natsumi1234);
insert into user(db_user_name, db_user_post, db_user_email, db_user_gender, db_user_pass) values(黒川国男,千葉県鎌ケ谷市右京塚,kuniokurokawa@ufbpql.cjhv.sov,男,kunio1234);
insert into user(db_user_name, db_user_post, db_user_email, db_user_gender, db_user_pass) values(那須藍,埼玉県鴻巣市笠原,ai944@dgjgpix.nc.ul,女,ai1234);
insert into user(db_user_name, db_user_post, db_user_email, db_user_gender, db_user_pass) values(麻生吉彦,栃木県宇都宮市六道町,yoshihiko_asou@dylos.uri,男,yoshihiko1234);
insert into user(db_user_name, db_user_post, db_user_email, db_user_gender, db_user_pass) values(三橋香織,高知県南国市立田,kaori9418@ipichq.mv,女,kaori1234);
insert into user(db_user_name, db_user_post, db_user_email, db_user_gender, db_user_pass) values(鈴木大造,広島県三次市三良坂町皆瀬,taizousuzuki@dlhbnv.etx,男,taizou1234);
insert into user(db_user_name, db_user_post, db_user_email, db_user_gender, db_user_pass) values(風間梨沙,青森県西津軽郡鰺ヶ沢町淀町,risakazama@ggjjbazlxp.hp,女,risa1234);

insert into user(db_item_code, db_item_name, db_item_price, db_item_category, db_item_review) values(いちばんやさしいJava　入門教室,2894,本,レビュー);
insert into user(db_item_code, db_item_name, db_item_price, db_item_category, db_item_review) values(新わかりやすいJava入門編,1814,本,レビュー);
insert into user(db_item_code, db_item_name, db_item_price, db_item_category, db_item_review) values(スラスラわかるHTML&CSSのきほん,第2版,本,レビュー);
insert into user(db_item_code, db_item_name, db_item_price, db_item_category, db_item_review) values(いちばんよくわかるHTML5&CSS3デザインきちんと入門,2678,本,レビュー);
insert into user(db_item_code, db_item_name, db_item_price, db_item_category, db_item_review) values(新しいLinuxの教科書,2916,本,レビュー);
insert into user(db_item_code, db_item_name, db_item_price, db_item_category, db_item_review) values(シェルスクリプトマガジン,vol.59,本,レビュー);
insert into user(db_item_code, db_item_name, db_item_price, db_item_category, db_item_review) values(WWE:レッスルマニア34,2173,DVD,レビュー);
insert into user(db_item_code, db_item_name, db_item_price, db_item_category, db_item_review) values(ふなっしーDVD　「ふなのみくす」,1850,DVD,レビュー);
insert into user(db_item_code, db_item_name, db_item_price, db_item_category, db_item_review) values(ピタゴラ装置　DVDブック2,,DVD,レビュー);
insert into user(db_item_code, db_item_name, db_item_price, db_item_category, db_item_review) values(HITOSHI:MATSUMOTO　Presents　ドキュメンタル　シーズン1,3068,DVD,レビュー);
insert into user(db_item_code, db_item_name, db_item_price, db_item_category, db_item_review) values(カメラを止めるな！スピンオフ「ハリウッド大作戦！」,2248,DVD,レビュー);
insert into user(db_item_code, db_item_name, db_item_price, db_item_category, db_item_review) values(ミスト　コレクターズ・エディション,2268,DVD,レビュー);

