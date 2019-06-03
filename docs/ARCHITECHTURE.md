                                      +-----------+
                                      |  Blossom  |
                                      +-----+-----+
                                            |
                                            |
                                            |
     +-------------------+------------------++-----------------+------------------------------+
     |                   |                   |                 |                              |
     |                   |                   |                 |                              |
     v                   v                   v                 v                              v
+----+------+       +----+---+           +---+---+        +----+-------+               +------+-----+
|Application|       |Business|           |Objects|        | Persistence|               |Presentation|
++----------+       ++-------+           ++------+        ++-----------+               +--+---------+
 |                   |                    |                |                              |
 |                   |                    |                |                              |
 +-->Main            +-->AccessAccount    +-->Account      +-->Stubs                      +-->AccountActivity
 |                   |                    |                |    +                         |
 |                   |                    |                |    |                         |
 +-->Services        +-->AccessTask       +-->Task         |    +->AccountPersistenceStub +-->TaskActivity
                     |                    |                |                              |
                     |                    |                |                              |
                     +-->AccessPlant      +-->Plant        +-->AccountPersistence         +-->PlantActivity

