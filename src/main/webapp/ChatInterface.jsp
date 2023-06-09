<%--
  Created by IntelliJ IDEA.
  User: air
  Date: 31/5/2023
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Entity.*" import="java.util.*"%>
<% UsersEntity authUser = (UsersEntity) session.getAttribute("auth-user");
  Collection<UsersEntity> allusers = (Collection<UsersEntity>) session.getAttribute("allusers");
  Collection<MessageEntity> messages =  (Collection<MessageEntity>) session.getAttribute("allmessages");
  Iterator<MessageEntity> itr = messages.iterator();
%>
<html>
<head>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <link rel="stylesheet" href="style.css">
  <title>Chat Room</title>
</head>
<body>
<section style="background-color: #CDC4F9;">
  <div class="container py-5">

    <div class="row">
      <div class="col-md-12">

        <div class="card" id="chat3" style="border-radius: 15px;">
          <div class="card-body">

            <div class="row">
              <div class="col-md-6 col-lg-5 col-xl-4 mb-4 mb-md-0">

                <div class="p-3">

                  <div class="input-group rounded mb-3">
                    <input type="search" class="form-control rounded" placeholder="Search" aria-label="Search"
                           aria-describedby="search-addon" />

                    <span class="input-group-text border-0" id="search-addon">
                      <i class="fas fa-search"></i>
                    </span>
                  </div>

                  <div class="scrollable-list" style=" height: 400px; overflow-y: auto;">
                    <ul class="list-unstyled mb-0">
                      <%for(UsersEntity e: allusers){%>
                      <li class="p-2 border-bottom">
                        <a href="#!" class="d-flex justify-content-between">
                          <div class="d-flex flex-row">
                            <div>
                              <img
                                      src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava1-bg.webp"
                                      alt="avatar" class="d-flex align-self-center me-3" width="60">
                              <span class="badge bg-success badge-dot"></span>
                            </div>
                            <div class="pt-1">
                              <p class="fw-bold mb-0"><%=e.getFirstName()%></p>
                              <p class="small text-muted">Hello, Are you there?</p>
                            </div>
                          </div>
                          <div class="pt-1">
                            <p class="small text-muted mb-1">Just now</p>
                            <span class="badge bg-danger rounded-pill float-end">3</span>
                          </div>
                        </a>
                      </li>
                      <%}%>

                    </ul>
                  </div>

                </div>

              </div>

              <div class="col-md-6 col-lg-7 col-xl-8">
              <div><span><%=authUser.getFirstName()%></span></div>
                <div class="pt-3 pe-3 scrollable-messages"
                     style="height: 400px; overflow-y: auto;">
                  <%while(itr.hasNext()){
                  MessageEntity msg = itr.next();
                  %>
                  <%if(msg.getUserId()==authUser.getId()){%>
                  <div class="d-flex flex-row justify-content-start">
                    <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava6-bg.webp"
                         alt="avatar 1" style="width: 45px; height: 100%;">
                    <div>
                      <p class="small p-2 ms-3 mb-1 rounded-3" style="background-color: #f5f6f7;"><%=msg.getContent()%></p>
                      <p class="small ms-3 mb-3 rounded-3 text-muted float-end"><%=msg.getTimestamp()%></p>
                    </div>
                  </div>
                  <%}else{%>

                  <div class="d-flex flex-row justify-content-end">
                    <div><span></span></div>
                    <div>
                      <p class="small p-2 me-3 mb-1 text-white rounded-3 bg-primary"><%=msg.getContent()%></p>
                      <p class="small me-3 mb-3 rounded-3 text-muted"><%=msg.getTimestamp()%></p>
                    </div>
                    <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava1-bg.webp"
                         alt="avatar 1" style="width: 45px; height: 100%;">
                  </div>
                  <%}%>
                  <%}%>

                </div>
              <form action="Send-Message-Servlet">
                <div class="text-muted d-flex justify-content-start align-items-center pe-3 pt-3 mt-2">
                  <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava6-bg.webp"
                       alt="avatar 3" style="width: 40px; height: 100%;">
                  <input type="text" name="Message" class="form-control form-control-lg" id="exampleFormControlInput2"
                         placeholder="Type message"><br>

                </div>
                <button type="submit" class="btn btn-primary btn-block mb-4">SEND</button>
              </form>
              </div>

            </div>

          </div>
        </div>

      </div>
    </div>

  </div>
</section>
<script src="https://kit.fontawesome.com/dcda0ea73a.js" crossorigin="anonymous"></script>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>
