## Git Commit Message
```text
Dev: 개발내용
Update: 코드수정, 기능 수정, 변경
Non: 개발관련 내용 외 모두
```

## Table Create
``` text
create table tb_chat_room (
	`room_id` INT NOT NULL AUTO_INCREMENT,
	`room_key` varchar(150) NOT NULL,
  `room_name` varchar(100) not null,
  `create_date` timestamp null,
  `modify_date` timestamp null,
  PRIMARY KEY(room_id)
);
```
