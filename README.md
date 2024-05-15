# MerchentGuide

Merchant's Guide to the Galaxy
 
You decided to give up on earth after the latest financial collapse left 99.99% of the earth's population with 0.01% of the wealth. Luckily, with the scant sum of money that is left in your account, you are able to afford to rent a spaceship, leave earth, and fly all over the galaxy to sell common metals and dirt (which apparently is worth a lot).
 
Buying and selling over the galaxy requires you to convert numbers and units, and you decided to write a program to help you.
 
The numbers used for intergalactic transactions follows similar convention to the roman numerals and you have painstakingly collected the appropriate translation between them.
 
Roman numerals are based on seven symbols:
 
Symbol     Value
  I         1
  V         5
  X        10
  L        50
  C        100
  D        500
  M       1,000

Numbers are formed by combining symbols together and adding the values. For example, MMVI is 1000 + 1000 + 5 + 1 = 2006. Generally, symbols are placed in order of value, starting with the largest values. When smaller values precede larger values, the smaller values are subtracted from the larger values, and the result is added to the total. For example MCMXLIV = 1000 + (1000 − 100) + (50 − 10) + (5 − 1) = 1944.
 
The symbols "I", "X", "C", and "M" can be repeated three times in succession, but no more. (They may appear four times if the third and fourth are separated by a smaller value, such as XXXIX.) "D", "L", and "V" can never be repeated.
"I" can be subtracted from "V" and "X" only. "X" can be subtracted from "L" and "C" only. "C" can be subtracted from "D" and "M" only. "V", "L", and "D" can never be subtracted.
Only one small-value symbol may be subtracted from any large-value symbol.
A number written in [16]Arabic numerals can be broken into digits. For example, 1903 is composed of 1, 9, 0, and 3. To write the Roman numeral, each of the non-zero digits should be treated separately. Inthe above example, 1,000 = M, 900 = CM, and 3 = III. Therefore, 1903 = MCMIII.
(Source: Wikipedia ( [17]http://en.wikipedia.org/wiki/Roman_numerals)
 
Input to your program consists of lines of text detailing your notes on the conversion between intergalactic units and roman numerals.
 
You are expected to handle invalid queries appropriately.
 
Test input:
glob is I
prok is V
pish is X
tegj is L
glob glob Silver is 34 Credits
glob prok Gold is 57800 Credits
pish pish Iron is 3910 Credits
how much is pish tegj glob glob ?
how many Credits is glob prok Silver ?
how many Credits is glob prok Gold ?
how many Credits is glob prok Iron ?
how much wood could a woodchuck chuck if a woodchuck could chuck wood ?
 
Test Output:
pish tegj glob glob is 42
glob prok Silver is 68 Credits
glob prok Gold is 57800 Credits
glob prok Iron is 782 Credits
I have no idea what you are talking about


## process:
- read file data
- validate data
- parse data
- add into database
- work on the query

## assupmtions
- If input line consist multiple spaces or tabs then I will replace it by single space
- As I am storing every line read from the file into the database the sequence of lines doesn't matter

## Design pattern
- Factory Design pattern:
  I used the factory design pattern to get the instance of different types of query processor classes fron the factory.

# domain Package - It consist domain models and domain services
## domain.model.entity Package - It consist all the entities

## IntergalacticUnit
### States
- `private final String intergalacticValue`
- `private final String romanValue`
- `private final double actualValue`

### Constructors
- `public IntergalacticUnit(String intergalacticValue, String romanValue, double actualValue)`
- `public static IntergalacticUnit create(String intergalacticValue, String romanValue, double actualValue)`

### Behaviors
- `getter methods`


## Metal
### States
- `private final String name`
- `private final double credits`

### Constructors
- `public Metal(String name, double credits)`
- `public static Metal create(String name, double credits)`

### Behaviors
- `getter methods`


## model.entity.validator Package - This package having classes for the validations of entities

## IntergalacticUnitValidator
### Behaviors
- `public static boolean isInvalidIntergalacticValue(String intergalacticValue)`
- `public static boolean isInvalidRomanValue(String romanValue)`


## MetalValidator
### Behaviors
- `public static boolean isInvalidMetalName(String name)`
- `public static boolean isInvalidCredits(double credits)`

## QueryDto
### States
- `private final QueryType queryType`
- `private final String queryContent`

### Constructors
- `public QueryDto(QueryType queryType, String queryContent)`
- `public static QueryDto create(QueryType queryType, String queryContent)`

### Behaviors
- `getter methods`

## QueryType
### Enum Values
- `METAL_QUERY`
- `INVALID_QUERY`
- `UNIT_QUERY`

## RomanNumbers
### States
- `I`: 1
- `V`: 5
- `X`: 10
- `L`: 50
- `C`: 100
- `D`: 500
- `M`: 1000

### Constructors
- `RomanNumbers(int value)`

### Behaviors
- `int getValue()`

## model.valueobject.validator Package - This package having classes for the validations of valueobjects

## QueryValidator
### Behaviors
- `public static boolean isValidQueryType(QueryType queryType)`
- `public static boolean isValidQueryContent(String queryContent)`


## domain.model.service Package - This package having domain service classes

## UnitQueryProcessor
### Behaviors
- `public String processQuery(String queryContent)`

## MetalQueryProcessor
### Behaviors
- `public String processQuery(String queryContent)`

## InvalidQueryProcessor
### Behaviors
- `public String processQuery(String queryContent)`

## UnitConverter
### Behaviors
- `public static long romanToDecimalConverter(String romanValue)`

## ProcessorFactory
### States
- `private final IntergalacticUnitService intergalacticUnitService`
- `private final MetalService metalService`

### Constructors
- `public ProcessorFactory(IntergalacticUnitService intergalacticUnitService, MetalService metalService)`

### Behaviors
- `public QueryProcessor getProcessor(QueryType queryType)`

## QueryProcessor(Interface)
### Behaviors
- `String processQuery(String queryContent)`

## InputParser
### Behaviors
- `static IntergalacticUnit parseUnit(String line)`
- `static MetalDto parseMetal(String line, IntergalacticUnitService intergalacticUnitService)`
- `static QueryDto parseQuery(String line)`

## InputValidator
### Behaviors
- `public static boolean unitValidator(String line)`
- `public static boolean metalCreditsValidator(String line)`

# controller Package - This package having controller classes

## IntergalacticUnitController
### States
- `private final IntergalacticUnitService intergalacticUnitService`

### Constructors
- `public IntergalacticUnitController(IntergalacticUnitService intergalacticUnitService)`

### Behaviors
- `public Response create(String intergalacticValue, String romanValue, int actualValue)`
- `public IntergalacticUnit get(String intergalacticValue)`


## MetalController
### States
- `private final MetalService metalService`

### Constructors
- `public MetalController(MetalService metalService)`

### Behaviors
- `public Response create(String name, long credits)`
- `public Metal getMetal(String name)`

## QueryController
### States
- `private final QueryService queryService`

### Constructors
- `public QueryController(QueryService queryService)`

### Behaviors
- `public Response create(QueryType queryType, String queryContent)`
- `public List<QueryDto> getAllQueries()`

## GalaxyController
### States
- `private final GalaxyService galaxyService`

### Constructors
- `public GalaxyController(GalaxyService galaxyService)`

### Behaviors
- `public boolean readFile(String filePath)`
- `public String processQueries()`


## controller.dto Package - This package consist class to return http status from the controller methods
## Response
### States
- `private final HttpStatus httpStatus`
- `private final String message`

### Constructors
- `public Response(HttpStatus httpStatus, String message)`

## HttpStatus
### Enum Values
- `BAD_REQUEST`
- `CONFLICT`
- `OK`

# service Package - Classes from this package are the middalware between controller layer and repository layer

## IntergalacticUnitService
### States
- `IntergalacticUnitRepository intergalacticUnitRepository`

### Constructors
- `public IntergalacticUnitService(IntergalacticUnitRepository intergalacticUnitRepository)`

### Behaviors
- `public IntergalacticUnit create(String intergalacticValue, String romanValue, double actualValue)`
- `public IntergalacticUnit get(String intergalacticValue)`

## MetalService
### States
- `MetalRepository metalRepository`

### Constructors
- `public MetalService(MetalRepository metalRepository)`

### Behaviors
- `public Metal create(String name, double credits)`
- `public Metal getMetal(String name)`

## QueryService
### States
- `QueryRepository queryRepository`

### Constructors
- `public QueryService(QueryRepository queryRepository)`

### Behaviors
- `public QueryDto create(QueryType queryType, String queryContent)`
- `public List<QueryDto> getAllQueries()`

## GalaxyService

### States

- `IntergalacticUnitService intergalacticUnitService`
- `MetalService metalService`
- `QueryService queryService`
- `ProcessorFactory processorFactory`

### Constructors

- `public GalaxyService(IntergalacticUnitService intergalacticUnitService, MetalService metalService, QueryService queryService, ProcessorFactory processorFactory)`

### Behaviors

- `public boolean readFile(String filePath)`
- `public String processQueries()`

# Repository Package - Classes from this package interact with the database, performing operations requested by the services.

## InMemoryIntergalacticUnitRepository

### States

- `private final InMemoryDatabase inMemoryDatabase`

### Constructors

- `public InMemoryIntergalacticUnitRepository(InMemoryDatabase inMemoryDatabase)`

### Behaviors

- `public IntergalacticUnit add(String intergalacticValue, String romanValue, double actualValue)`
- `public IntergalacticUnit find(String intergalacticValue)`

## InMemoryMetalRepository

### States

- `private final InMemoryDatabase inMemoryDatabase`

### Constructors

- `public InMemoryMetalRepository(InMemoryDatabase inMemoryDatabase)`

### Behaviors

- `public Metal add(String name, double credits)`
- `public Metal selectFromMetalTable(String name)`

## InMemoryQueryRepository

### States

- `private final InMemoryDatabase inMemoryDatabase`

### Constructors

- `public InMemoryQueryRepository(InMemoryDatabase inMemoryDatabase)`

### Behaviors

- `public QueryDto add(QueryType queryType, String queryContent)`
- `public List<QueryDto> getAllQueries()`

## FakeInMemoryDatabase

### States

- `List<IntergalacticUnit> intergalacticUnits`
- `List<Metal> metals`
- `List<QueryDto> queries`

### Behaviors

- `public IntergalacticUnit InsertIntoIntergalacticUnitTable(String intergalacticValue, String romanValue, double actualValue)`
- `public IntergalacticUnit selectFromIntergalacticUnitTable(String intergalacticValue)`
- `public Metal InsertIntoMetalTable(String name, double credits)`
- `public Metal selectFromMetalTable(String name)`
- `public QueryDto insertIntoQueryTable(QueryType queryType, String queryContent)`
- `public List<QueryDto> getAllQueries()`
