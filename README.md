# Packaging-Challenge
Packaging code challenge for Mobility

Project description can be found at the root folder of repository. Knapsack algorithm with
recursion and memoization is used to find the solution.

For memoization key is constructed as
knapsack(<param1><param2>), because actually we skip the call exactly this function if it is called
before. <b>HashMap</b> is used for instead of <b>2D array</b> because weight is double not integer.

There is a util part of project which have <b>ItemBuilder</b>, <b>PackageFileParser</b> and <b>UTF8FileReader</b>


Project includes <b> lombok </b> dependency. It has to be added to the IDE to have a working project.

Example inputs and unit tests which are written with JUnit5 can be found at <b>src/main/test/java/mobiquity</b>
and <b>src/main/test/resources</b> folder.