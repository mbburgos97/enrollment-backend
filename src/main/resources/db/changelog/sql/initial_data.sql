--Note: Put Student and teacher priority when inserting because other table has foreign keys

INSERT INTO public.student (student_id,first_name,middle_name,last_name,created_at,updated_at,profile_image,username,"password",email,contact_number,nickname) VALUES
	 ('2013-08997','Noreen Louise','Calisay','Bundoc','2022-01-30 21:26:24.079095',NULL,'profileImageeee','username111','samplePassword','sample@email.com','0928121','Reen'),
	 ('2013-11122','asdasd','zxczxc','zxczxc','2022-02-03 20:58:19.832418',NULL,'','usernameWhite','sample','change2@gmail.com','123456',''),
	 ('2013-09836','asjkdh','Test222','Burgos','2022-01-13 20:10:07.651699','2022-01-13 20:10:07.651699','','','foo','sample@meial.com','+63912344544','testz');

INSERT INTO public.teacher (teacher_id,first_name,middle_name,last_name,created_at,updated_at,profile_image,username,"password",email,contact_number,nickname) VALUES
	 ('2022-09123','Josh','Bucad','Burgos','2022-01-13 20:10:07.651','2022-01-13 20:10:07.651','https://i.ibb.co/Sf7XVDn/profile-pic.jpg','foo','foo','foo',NULL,'foo'),
	 ('2011-11223','Sam','White','Brown','2022-02-04 21:26:00.292699','2022-02-04 21:26:00.292736','','samwbrown','asd','sample@sample.com','123098',''),
	 ('2011-11111','John','White','Brownieeee','2022-02-01 20:49:07.792575','2022-02-01 20:49:07.792623','profileImageeee','userna2222','asdads','sample@email2.com','0928121111','sampleNickname');

INSERT INTO public.subject (teacher_id,title,created_at,updated_at) VALUES
	 ('2022-09123','English','2022-01-13 20:10:07.651',NULL);

INSERT INTO public.announcement (title,subject_id,"content",teacher_id) VALUES
	 ('sample Announcement title',1,'sample announcement content','2022-09123'),
	 ('sample Announcement title2',1,'sample announcement content2','2022-09123');
