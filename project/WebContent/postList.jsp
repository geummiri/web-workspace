<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>postList</title>
    <!-- link
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
        rel="stylesheet"
        integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
        crossorigin="anonymous"/>
      <script src="https://code.jquery.com/jquery-3.7.0.min.js"></script> 
      -->
      <style>
        #menu_id {
            font-size : 30px;
            margin: 20px;
        }

        tr {
            font-size: 18px;
            display : flex;
            justify-content: space-around;
        }


      </style>
</head>
<body>
    <!--메인페이지에서 메뉴 클릭 했을 시 해당 페이지 리스트로 넘어감
    이름은 임의로 해두며 추후 이름 값 받아와서 넣기-->
    <div id="menu_id">Q. 마이페이지</div>
    <hr solid />
    <div id="post_head">
      <!--DB 변수명이랑 같게함 -->
      <!--작성자는 이름 or 익명닉네임 값 받아오기-->
    <table class="table">
    <thead>
      <tr>
        <th id="post_no">번호</th>
        <th id="post_title">제목</th>
        <th id="name">작성자</th>
        <th id="create_time">작성일</th>
        <th id="view">조회</th>
        <th id="like_no">좋아요</th>
      </tr>
    </thead>

    <tbody>
        <c:forEach items="${list}" var="post">
      <tr>
        <!--<td>${post.post_no}</td>
        <td>${post.post_title}</td>
        <td>${post.name}</td>
        <td>${post.create_time}</td>
        <td>${post.view}</td>
        <td>${post.like_no}</td>-->
         <td>번호</td>
         <td>제목</td>
         <td>작성자</td>
         <td>작성일</td>
         <td>조회</td>
         <td>좋아요</td>  
      </tr>
    </c:forEach>
    </tbody>
</table>
    
        <div>
            <span>
              <select id="date">
                <option value="all">전체기간</option>
                <option value="day">1일</option>
                <option value="week">1주</option>
                <option value="month">1달</option>
                <option value="year">1년</option>
              </select>
            </span>
      
            <span>
              <select id="post_select">
                <option value="">게시물+댓글</option>
                <option value="week">게시물</option>
                <option value="month">댓글</option>
              </select>
            </span>
      
            <input type="text" id="search" placeholder="검색어를 입력하세요." />
            <input type="button" value="검색">
          </div>

   
   
    
</body>
</html>