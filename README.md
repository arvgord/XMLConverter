# XMLConverter
Имеется библиотека в формате XML.  
Библиотека может иметь 4 представления:
* ATTRIBUTE_BASED
* ELEMENTS_BASED
* FLAT
* TABLE_OF_CONTENT

В библиотеке может содержаться несколько книг.  
Необходимо произвести чтение библиотеки в одном из представлений и произвести запись в XML файл в другом представлении. Книга имеет название, название главы, название секции и текст.
***
### Описание реализации
* Параметры для чтения и записи библиотеки передаются через консоль в следующем виде:  
-i books/ELEMENTS_BASED.xml -o output.xml -p ELEMENTS_BASED -w ATTRIBUTE_BASED  
Параметры -i - (input) файл библиотеки, -o - (output) файл библиотеки, -p - (parser) параметры парсера, - (writer) параметры записи;
* Чтение и запись библиотеки производится с помощью StAX парсера;
* Для логгирования событий используется Log4j2;
* Запись логов производится на консоль и в файл Converter.log.
