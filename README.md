<html>
<head>
 <h1> Film App Uygulama Detayları</h1>
</head>
<body>
 
 
 👋Arkanıza yaslanıp incelemelik bir uygulamayı sizlere sunmaktan onur duyarım.
 Bu uygulamada bir çok compenentlerin güncel hallerini kullanarak bir 
 Movie eApp yapmaya çalıştım.İnceleyen arkadaşlara faydalı olması dileğiyle ⚡⚡⚡ :)
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
    -Uygulamayı ilk başlattığımızda splash ekranda daha önce giriş yapıp yapmadığımız kontrol ediliyor.Eğer
    İlk olarak  giriş yapıyorsak splash ekran  bizi aşağıdaki giriş ekranına yönlediriyor<br>
    <br>
      <img src="https://github.com/erkocali1/ss/blob/master/app/src/main/res/drawable/login.jpeg"  width="200" height="500" > 
     <br>  
 -Daha önce giriş yapıp bilgilerimizi girdiysek Shared Preferencesta tutulan giriş bilgileri splash ekranda kontrol ediliyor ve bizi aşağıdaki seçim ekranına yönlediriyor.
 Seçim ekranında fragment container view ve bottom navigation view bizlere istenilen fragmentlara Navigation Component  sayesinde geçiş imkanı sağlıyor.  <br> 
   <br>  
 <img src="https://github.com/erkocali1/ss/blob/master/app/src/main/res/drawable/secim.jpeg"  width="200" height="500" >
 -Seçim ekranındandan sonra Retrofit den çektiğimiz veriler RecyclerView yardımıyla liste halinde görmemize olanak sağlıyor ve aşağıdaki ekranları oluşturuyor. <br>  
<div style="display: flex;">
  <img src="https://github.com/erkocali1/ss/blob/master/app/src/main/res/drawable/movie.jpeg" width="200" height="500" style="padding-right: 300 px;">
  <img src="https://github.com/erkocali1/ss/blob/master/app/src/main/res/drawable/tv.jpeg" width="200" height="500">
</div>
 <br>
 -İzlenmek istenen liste elemanına tıklanınca adapter daki Onclick methodun çağrılmasyla aşağıdaki  detay  sayfaları açılıyor.
   <img src="https://github.com/erkocali1/ss/blob/master/app/src/main/res/drawable/detay.jpeg" width="200" height="500">

 
 
</p>
 

</body>
 

 
 
</html>
