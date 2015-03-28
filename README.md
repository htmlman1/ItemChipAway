# ItemChipAway
*A plugin that causes players to drop items upon death - based on a request by Bukkit Forums member RainingDolphins.*

The config file's default format is as follows:
```yml
toggle: ON
chance: 100
items:
- GOLD_INGOT
- MUSHROOM_SOUP
```
An explanation of the keys and their values follows:

Key          | Value
:---------:  | ---------
toggle       | Controls the activity of the plugin - alternates between *ON* and *OFF*.
chance       | Controls the chance that the player will drop items upon damage. Can be a value between 0 and 100 - decimals                    *are* accepted.
items        | The list of items that can drop. Including GOLD_INGOT, for example, will allow for said item to drop. Valid                     material types may be found in Bukkit's Material Enum. https://github.com/Bukkit/Bukkit/blob/master/src/main/java/org/bukkit/Material.java.
