PAInspector
===========

Available commands:
	• q : Terminates inspection, allowing the calling program to proceed its execution.

	• i name : Inspects the value of the field named name of the object currently presented and makes that 
	value the current inspected object.
	
	• m name value : Modifies the value of the field named name of the object currently presented so that it 
	becomes value. This command must support, at minimum, fields of type int.

	• c name value 0 value 1 ...value n : Calls the method named name using the currently presented object 
	as receiver and the provided values as arguments and inspects the returned value, if there is one. This
	command must support, at minimum, calling methods that do not have parameters and methods that
	require arguments of type int.

	• u : Navigates up in the graph of inspected objects, putting the previous inspected object as the current
	object being inspected.

	• d : Navigates down in the graph of inspected objects. If there is more than one option in the graph, it
	asks the user to choose one of the options.

	• s name : Saves the current object with the name name of future usage. To use this saved object in the
	commands c and m, you have to add the character ' before the name of the saved objects. (For example:
	m nameofthefield 'nameofthesavedobject)

	• o name : Puts the saved object with name name as the current object.
	
	
	 
	

