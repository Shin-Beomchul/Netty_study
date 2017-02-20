# Netty_study
네티의 서막 2017.1.14

 

Lecure 1. 
   - Plain OioSocket 을 구현
   - Blocking를 확인함
Lecure 2.   
   - Netty로EchoServer를구현함
   - pipeLine에핸들러를추가해봄
Lecure 3. 
   - Netty로CommandServer를구현함
   -Decode,Incode를 사용한뒤 Pipe체인을 이용Decode처리후 다음Bussiness Chain에 넘겨 비즈니스 처리함
Lecure 4. 
   -plainNio, OIOServer를 구현해봄
      -Plainjava의OIO/NIO간 마이그레이션이 굉장히 복잡하고 함들다는 것을 암
      -Netty는노출된인터페이스가OIO/NIO가 동일하게 노출되어 있으므로 마이그레이션이 굉장히 쉬움
      -Epoll이 훨씬효율적임
   
