# assignment4
                              [ KittenDorm | Publisher ]
                              - students: List<Observer>
                              - kittens: List<Kitten>
                              -------------------------
                              + addObserver
                              + removeObserver
                              + publishKitten
                              + notifyOberservers
                              + getStudents
                              + getKittens
                              -------------------------
                              /                        \
              [Student | Concrete Observer]       [Kitten | Product Interface]
              - name: String                      + getDescription
              - budget: double                        /        \
              - adoptedKitten: Kitten                /          \
              ------------------------              /            \
              + getName                            /              \
              + getAdoptedKitten                  /                \
              + update                           /                  \
                                                /                    \
                                               /                      \
                            [StrayKitten | Concrete Product] [BreededKitten | Concrete Product]
                            - name: String                   - name: String
                            + getName                        + getDescription
                            + getDescription


                            
1. SRP: each class has a single resposibility
2. OCP: easily add new types of kittens (new concrete products) or students (new observers)
3. LSP: 'StrayKitten' and 'BreededKitten' are SUBSTUTABLE for the base class 'Kitten'
4. ISP: The 'Observer' interface is minimal with a single 'update' method. The concrete observers implement only the methods they NEED.
5. DIP: high-level modules 'KittenDorm' depend on abstractions 'Observer' interface but not the concrete classes
