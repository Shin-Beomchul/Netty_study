Lecure 1. <br>
     - Plain OioSocket 을 구현<br>
     - Blocking를 확인함<br>
 +   <br>
  Lecure 2.   <br>
     - Netty로EchoServer를구현함<br>
     - pipeLine에핸들러를추가해봄<br>
 +   <br>
  Lecure 3. <br>
     - Netty로CommandServer를구현함<br>
     -Decode,Incode를 사용한뒤 Pipe체인을 이용Decode처리후 다음Bussiness Chain에 넘겨 비즈니스 처리함<br>
 +   <br>
  Lecure 4. <br>
     -plainNio, OIOServer를 구현해봄<br>
        -Plainjava의OIO/NIO간 마이그레이션이 굉장히 복잡하고 함들다는 것을 암<br>
        -Netty는노출된인터페이스가OIO/NIO가 동일하게 노출되어 있으므로 마이그레이션이 굉장히 쉬움<br>
        -Epoll이 훨씬효율적임<br>
 +      <br>
