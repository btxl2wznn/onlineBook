
























































<%--
  Created by IntelliJ IDEA.
  User: p
  Date: 2020/7/26
  Time: 9:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<script src="https://cdn.bootcdn.net/ajax/libs/axios/0.20.0-0/axios.min.js"></script>
  <head>
    <title>$Title$</title>
      <script type="text/javascript" charset="utf-8">

          function d1() {
              var user=document.getElementById("username").value;
              var pass=document.getElementById("password").value;
              let model = {'username':user,
                  'password':pass}
              axios.post("LoginServlet",model)
                  .then(function (response) {
                      alert(response.data.message);
                  });
          }
          function d3() {
              var user=document.getElementById("username").value;
              var pass=document.getElementById("password").value;
              let model = {'id':13,
                  'password':pass}
              axios.post("BackDElBook",model)
                  .then(function (response) {
                      alert(response.data.message);
                  });
          }
          function d2() {

              axios.get("BackGETBook",{param:{}})
                  .then(function (response) {
                      alert(response.data[88].name);
                      alert(response.data[88].icon);
                      document.getElementById("nihao").innerHTML="<img src="+response.data[88].icon+">";
                  });
          }
          function d4() {

              let model = {'name':"傻逼刘佳伟",
                  'author':"刘佳伟",
              'category':"煞笔",
              'outline':"刘佳伟是个大傻逼哈哈哈哈",
              'icon':"http://192.168.43.111:9090/OnlineReader/book/6F712E668998D0682D37CD2DBAEF8539.jpg"};
              axios.post("BackADDBook",model)
                  .then(function (response) {
                      alert(response.data.message);
                  });
          }
          function d5() {

              axios.get("BackGETCapters",{params:{
                      'bname':'傻逼刘佳伟'
                }
              })
                  .then(function (response) {
                      alert(response.data[0].context);
                      document.getElementById("nihao").innerHTML=response.data[0].context;

                  });
          }
          function d6() {

              let model = {'username':"a674639701",
                  'password':"123456z"};
              axios.post("BackADDAdmin",model)
                  .then(function (response) {
                      alert(response.data.message);
                  });
          }
          function d7() {

              axios.get("BackQueryUser",{params:{
                      'userType':'普通用户'
                  }
              })
                  .then(function (response) {
                      alert(response.data[0].id);
                      alert(response.data[0].username);


                  });
          }
          function d8() {

              let model = {'bookname':"大主宰",
                  'captername':"第100章，佳伟是猪",
                  'capternum':"100",
                  'context':"佳伟是猪价位是猪佳伟是猪价位是猪佳伟是猪价位是猪佳伟是猪价位是猪佳伟是猪价位是猪佳伟是猪价位是猪佳伟是猪价位是猪佳伟是猪价位是猪佳伟是猪价位是猪"
              };
              axios.post("BackADDCapter",model)
                  .then(function (response) {
                      alert(response.data.message);
                  });
          }
          function d9() {
              let model = 130;
              axios.post("BackDELCapter",model)
                  .then(function (response) {
                      alert(response.data.message);
                  });
          }
          function d10() {
              let model = 805;
              axios.post("BackDELUser",model)
                  .then(function (response) {
                      alert(response.data.message);
                  });
          }
          function d11() {
              let param = new FormData();  // 创建form对象
              param.append('icon', document.getElementById("file").files[0]) ; // 通过append向form对象添加数据
              param.append('chunk', '0') ;// 添加form表单中其他数据
              console.log(param.get('file')); // FormData私有类对象，访问不到，可以通过get判断值是否传
              let config = {
                  headers: {'Content-Type': 'multipart/form-data'}
              }
              axios.post("BackGetImg",param,config)
                  .then(function (response) {
                      console.log(response.data.url);
                      alert(response.data.message);
                      alert(response.data.url);
                  });
          }
          function d12() {

              let model = {'id':"99",
                  'name':"傻逼·方静龙",
                  'author':"刘佳伟",
                  'info':"方静龙是个大傻逼哈哈哈哈",
                  'type':"傻逼",
                  'icon':"http://192.168.43.111:9090/OnlineReader/book/6F712E668998D0682D37CD2DBAEF8539.jpg"};
              axios.post("BackUPBook",model)
                  .then(function (response) {
                      alert(response.data.message);
                  });
          }
          function d13() {

              let model = {
                  'id':"888",
                  'username':"傻逼·方静龙",
                  'password':"景龙傻逼",
                  'nick':"亲爱的"};
              axios.post("BackUPUser",model)
                  .then(function (response) {
                      alert(response.data.message);
                  });
          }
          function d14() {

              let model = {'name':"大主宰"};
              axios.post("BackQUEBook",model)
                  .then(function (response) {
                      alert(response.data._id);
                      alert(response.data.message);
                  });
          }
          function d15() {

              let model = {'id':"140",
              'name':"第八百八十八章，佳伟吃屎",
              'text':"方静龙傻逼"};
              axios.post("BackUPCapter",model)
                  .then(function (response) {
                      alert(response.data.message);
                  });
          }
          function d16() {

              let model = {'username':"a674639706",
                  'password':"123456z"};
              axios.post("BackADDUser",model)
                  .then(function (response) {
                      alert(response.data.message);
                  });
          }
          function d17() {
              var user=document.getElementById("username").value;
              var pass=document.getElementById("password").value;
              let model = {'username':user,
                  'password':pass}
              axios.post("ComLogin",model)
                  .then(function (response) {
                      alert(response.data.message);
                  });
          }
          function d18() {

              axios.get("GetReadBook",{params:{

                  }
              })
                  .then(function (response) {
                      alert(response.data[0]._id);
                      alert(response.data[0].name);
                      alert(response.data[0].page);
                      document.getElementById("nihao").innerHTML="<img src="+response.data[88].icon+">";


                  });
          }
          function d19() {

              var page=Number(document.getElementById("nihao5").value);
                  let model = {'page':page-1};
                  axios.post("PageReadBook",model)
                      .then(function (response) {
                          alert(response.data.message);
                          alert(response.data[0]._id);
                          alert(response.data[0].name);
                          alert(response.data[0].page);
                          alert(response.data[0].icon);
                          document.getElementById("nihao5").value=page-1;
                          document.getElementById("nihao").innerHTML="<img src="+response.data[0].icon+">";
                      });

          }
          function d20() {

                  var page=Number(document.getElementById("nihao5").value);
                  let model = {'page':page+1};
                  axios.post("PageReadBook",model)
                      .then(function (response) {
                          alert(response.data.message);
                          alert(response.data[0]._id);
                          alert(response.data[0].name);
                          alert(response.data[0].page);
                          alert(response.data[0].icon);
                          document.getElementById("nihao5").value=page+1;
                          document.getElementById("nihao").innerHTML="<img src="+response.data[1].icon+">";
                      });

          }
          function d21() {

              axios.post("GiveThunmbUp",14)
                  .then(function (response) {
                      alert(response.data.message);
                  });

          }

          function d22() {
              let model = {'username':"a674639701",
                  'id':1}
              axios.post("AddUserShelf",model)
                  .then(function (response) {
                      alert(response.data.message);
                  });
          }
          function d23() {
              let model = {'username':"a674639701"}
              axios.post("GetUserShelf","a674639701")
                  .then(function (response) {
                      alert(response.data.message);
                      alert(response.data[0]._id);
                      alert(response.data[0].name);
                      document.getElementById("nihao").innerHTML="<img src="+response.data[1].icon+">";
                  });
          }
          function d24() {

              let model = {'name':"大主宰"};
              axios.post("QueryBook",model)
                  .then(function (response) {
                      alert(response.data[0]._id);
                      alert(response.data[0].message);
                  });
          }
          function d25() {

              let model = {'name':"第一",
              'bname':"大主宰"};
              axios.post("QueryCapter",model)
                  .then(function (response) {
                      alert(response.data[0].title);
                      alert(response.data[0].message);
                  });
          }
          function d26() {

              let model = {
                  '_id':"1",
              };
              axios.post("GetCapter",model)
                  .then(function (response) {
                      alert(response.data[0]._id);
                      alert(response.data[0].bname);
                      alert(response.data[0].title);
                      alert(response.data[0].num);
                      alert(response.data[1].num);
                  });
          }
          // function d27() {
          //
          //     let model = {'_id':"1",
          //         'bid':"1"};
          //     axios.post("GetCapter",model)
          //         .then(function (response) {
          //             alert(response.data[0].name);
          //             alert(response.)
          //         });
          // }
          function d28() {

              axios.get("GetTypeNum",{params:{

                  }
              })
                  .then(function (response) {
                      alert(response.data[0].玄幻);
                      alert(response.data[0].name);
                      alert(response.data[0].page);
                      document.getElementById("nihao").innerHTML="<img src="+response.data[88].icon+">";


                  });
          }
          function d29() {

              let model = {
                  'category':"玄幻",
                  'page':1
              };
              axios.post("QueryByType",model)
                  .then(function (response) {
                      alert(response.data[0]._id);
                      alert(response.data[0].name);
                      alert(response.data[0].body);
                      alert(response.data[0].name);
                      alert(response.data[1].name);
                  });
          }

      </script>
  </head>
  <body>
 用户名: <input type="text" id="username">
 密码: <input type="text" id="password">
 <input type="button" value="你好" onclick="d1()">
 <input type="button" value="谢谢" onclick="d2()">
 <input type="button" value="哈罗" onclick="d3()">
 <input type="button" value="煞笔" onclick="d4()">
 <input type="button" value="猪头" onclick="d5()">
 <input type="button" value="我炸了" onclick="d6()">
 <input type="button" value="真就一枪头啊" onclick="d7()">
 <img src="./book/a1.jpg" width="240" height="320"/>
  <div id="nihao"></div>
  <div style="background-color: aqua">
      <input type="button" value="来嘛拉出来嘛" onclick="d8()">
      <input type="button" value="A1高闪来一个好吗" onclick="d9()">
      <input type="button" value="秋梨膏" onclick="d10()">
      <form action="" method="post" enctype="multipart/form-data">
      <input type="button" value="真就一枪头啊" onclick="d11()">
      </form>
      <form id="uploadForm" enctype="multipart/form-data" method="post" action="BackGetImg">
          <input id="file" type="file" name="file"/>
          <input name="uploaderName" type="text"/>
          <input type="submit" value="提交"/>
      </form>
  </div>
 <input type="button" value="wdnmd" onclick="d12()">
 <input type="button" value="cnmd" onclick="d13()">
 <input type="button" value="窗帘擦嘴" onclick="d14()">
 <input type="button" value="GK!!!" onclick="d15()">
 <input type="button" value="nmlgb" onclick="d16()">
 <input type="button" value="又是你GK！！！！" onclick="d17()">
 <input type="button" value="我傻了" onclick="d18()">
 <input type="button" value="说！你是猪！" onclick="d19()">
 <input type="button" value="你是猪55555555555555" onclick="d20()">
 <input type="button" value="这波啊这波是肉蛋冲击" onclick="d21()">
 <input type="button" value="遇到老虎不要怕" onclick="d22()">
 <input type="button" value="我先一个滑铲" onclick="d23()">
 <input type="button" value="然后给他来一拳" onclick="d24()">
 <input type="button" value="老虎就倒了" onclick="d25()">
 <input type="button" value="奈斯大夫" onclick="d26()">
 <input type="button" value="方静龙傻逼" onclick="d28()">
 <input type="button" value="这部小老弟吗" onclick="d29()">
  <button id="nihao5" value=1></button>
  </body>
</html>
