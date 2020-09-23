# wonka-hr

URL: http://localhost/wonka-hr/oompa-loompa
    
   Operations / HTTP methods:
    
    GET to obtain full list of Oompa-Loompas
        add /{name} to the URL to get an specific OL
    
    POST to create a new Oompa-Loompa with this example body:
        {
          "name": "Ronn",
          "age": 47,
          "job": "Farmer",
          "height": 69,
          "weight": 1.9,
          "description": "Best Farmer Ever!"
        }
    
    PUT to modify an existing Oompa-Loompa with this example body:
        {
          "name": "Ronn",
          "age": 47,
          "job": "Farmer",
          "height": 69,
          "weight": 1.9,
          "description": "Best Farmer Ever!"
        }
