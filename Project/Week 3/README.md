# ITU ACM 2018 - Android Programming Study Group
## Project - Week 3

Third week of the project is about local storages. Untill now, we can send a API requst and show the response in awesome views.

We will implement a big feature in our project this week. Earlier, we said that users can store to the information they like. So we will implement a local database to add this feature to our app.


Here is the complete list of things to do:

1. Create a Database Helper class where add, delete and select operations will be implemented.
2. Add a button to homepage fragment to store the information. Invoke database write call with when it clicked.
3. Invoke the select call of the database to get archived items in archived fragment.
4. Open a fragment when archived item clicked in recyler view.
5. Add delete method to somewhere of the app.

Notes:

* You may have to change the class which keeps the information(Film class for our project).
* For the 4. task you can use homepage fragment instead of creating a new one.
* You can add the delete method to a Recycler View Item with onLongClick or with a button added to item.
