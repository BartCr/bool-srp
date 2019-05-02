Single Responsibility Principle: Kindergarten
===

The class `Kindergarten` models a kindergarten. It has a number of children and a number of caregivers.

Every month, a report is generated for the parents of the children.
It states the total number of children in the kindergarten.

A report is also generated for the owner.
It states the total number of children in the kindergarten
and also the total number of caregivers.

Auditors of the government also need a report.
They simply want to know that it is possible for the owner to split into groups
where there are no more than six children per caregiver.

The class also provides a (naive) mechanism to serialize and deserialze the class
 to and from a string.
 
 Try to apply the single responsibility principle.