# card-system
Учебный проект для изучения абстракции и проектирования приложения

Используемые технологии: Java 11, Maven, Spring
![alt text](doc/uml.png)

1. изучить архитектуру проекта
2. согласно архитектуре создать сервис(по аналогии с LoggerWriterService) для записи объекта Пользователь в файл формата csv (значения полей класса Пользователь должны быть записаны с разделителем ";". Пример: Имя;Фамилия;Отчество;... и тд)
3. согласно архитектуре создать контроллер(по аналогии с ButtonWriterToLoggerController) для кнопки взаимодействующей с созданным сервисом
4. добавить в PanelController созданный контроллер и добавить, по аналогии, в initButtonPanel() вызов метода из контроллера
5. запустить проект и проверить работоспособность
