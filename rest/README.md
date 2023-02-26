***REST сервис***

>_Первый запуск:_
> 
> Нужно скопировать src/main/resources/application.properties.example в src/main/resources/application.properties

# **Документация:**

_**Тип запрос:**_ *POST*

**_Эндпоинт:_** */v1/general/contains*

**_Request Body:_**

>       {
>           "rootPath": "string"
>       }
> 
> _rootPath - путь до корневой папки (обязательное поле, не может быть null)_

**_Response body:_**

>      {
>           "documentCount": int,
>           "pageSum": int
>      }  
> 
> _documentCount - суммарное количество документов в корневой папке;_
> 
> _pageSum - суммарное количетсво страниц во всех файлах корневой папки;_