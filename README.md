<html>
<head>
 <h1> Film App Uygulama Detayları</h1>
</head>
<body>
 
 
 👋Arkanıza yaslanıp incelemelik bir uygulamayı sizlere sunmaktan onur duyarım.
 Bu uygulamada bir çok compenentlerin güncel hallerini kullanarak bir 
 Movie App yapmaya çalıştım.İnceleyen arkadaşlara faydalı olması dileğiyle ⚡⚡⚡ :)
  <img src="https://github.com/erkocali1/ss/blob/master/app/src/main/res/drawable/zx.jpg"  width="500" height="300" >
 
  <h1>İşte Kullandığım Bazı Yapılar </h1>
   <p>
- Navigation Component <br>
-Room Data Base<br>
-Retroif<br>
 -Recycler View<br>
-View Binding<br>
    -Shared Preferences<br>
    <br>
    <h3>Şimdi de Kullanıcı Arayüzünden Bahsedelim:<br></h3>
    <br>
    -Uygulamayı ilk başlattığımızda Splash ekranda daha önce giriş yapıp yapmadığımız kontrol ediliyor.Eğer
    ilk olarak  giriş yapıyorsak Splash ekran  bizi aşağıdaki giriş ekranına yönlediriyor<br>
    <br>
      <img src="https://github.com/erkocali1/ss/blob/master/app/src/main/res/drawable/login.jpeg"  width="200" height="500" > 
     <br>  
 -Daha önce giriş yapıp bilgilerimizi girdiysek Shared Preferences da tutulan giriş bilgileri Splash ekranda kontrol ediliyor ve bizi aşağıdaki seçim ekranına yönlediriyor.
 Seçim ekranında Fragment Container View ve Bottom Navigation View bizlere istenilen fragmentlara Navigation Component i  sayesinde geçiş imkanı sağlıyor.  <br> 
   <br>  
 <img src="https://github.com/erkocali1/ss/blob/master/app/src/main/res/drawable/secim.jpeg"  width="200" height="500" >
 -Seçim ekranındandan sonra Retrofit den çektiğimiz veriler RecyclerView yardımıyla liste halinde görmemize olanak sağlıyor ve aşağıdaki ekranları oluşturuyor. <br>  
<div style="display: flex;">
  <img src="https://github.com/erkocali1/ss/blob/master/app/src/main/res/drawable/movie.jpeg" width="200" height="500" style="padding-right: 300 px;">
  <img src="https://github.com/erkocali1/ss/blob/master/app/src/main/res/drawable/tv.jpeg" width="200" height="500">
</div>
 <br>
 -İzlenmek istenen liste elemanına tıklanınca Adapter daki Onclick methodun çağrılmasyla aşağıdaki  detay  sayfaları açılıyor ve burada yine Retroifit yardımıyla API dan alınan veriler Viewbinding yöntemi le bind ediliyor ayrıca İstenilen veri Fab buton yardımyla Favorites listesine alınarak Room Database de kaydediliyor.
  <br>
   <img src="https://github.com/erkocali1/ss/blob/master/app/src/main/res/drawable/detay.jpeg" width="200" height="500">
 <br>
 -Aşağıdaki Bottom Navigation Bar sayesinde istenilirse Favorites listesine geçilebilir.Buradada Room Database kaydedilen veriler Recyclerview yardımıyla listelenbiliyor ve istenilirse burda silinerek Roomdan silinebiliyor.Ayrıca Bottom Navigation Bar da bulunan Login Fab butonuna basarak kullanıcı bilgileri gözlemlenebilir dilenirse çıkış yapılarak tüm kaydedilen bilgiler silinerek tekrardan Login Ekranına yönledirilebilir.
  <br> 
 <div style="display: flex;">
  <img src="https://github.com/erkocali1/ss/blob/master/app/src/main/res/drawable/fav.jpeg" width="200" height="500" style="padding-right: 300 px;">
  <img src="https://github.com/erkocali1/ss/blob/master/app/src/main/res/drawable/logout.jpeg" width="200" height="500">
</div>
 
</p>
 

</body>
 

 
 
</html>
