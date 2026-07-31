# Changelog

## 1.21.1-1.6.5

- Fix Miners not seeing the bedrock / void
- Make recipe ID show in JEI

## 1.21.1-1.6.4

- Lot of optimization of the Miners and Solars Controllers
  - Tested with up to 131 072x tick acceleration
- Replaced Structure Helper with Structure Builder
  - Sneak + right-click a Controller with it to automatically take blocks from the player's inventory and build the multiblock
  - In creative, it just places the multiblock, don't have to have the items

## 1.21.1-1.6.3

- Make the Max Storage Upgrades use Components to tell how many slots they will add
- This change makes them not hot-changeable, if you change the config for them, you will have to close the game and re-open it
- This also makes it so KubeJS can add custom ones, see [wiki.md](https://github.com/Minimaxi28/VoidMiners-Remastered-Reforked/wiki#add-custom-max-storage-upgrades)

## 1.21.1-1.6.2

- Fix the Miners rendering the Solar multiblocks
- Fix the lag generated when breaking a Miner / Solar Controller due to their complex shapes
- Add MINERS_AUTO_EXPORT_INSTEAD_OF_FILLING_THEIR_OWN_INVENTORY config
  - Miners will search in every direction for a valid inventory and push it's generated items into it instead of its own inventory 
  - It will not respect its slot limit, Max Storage Upgrades become useless 
  - If multiple inventories are available, it will fill one first then another...

## 1.21.1-1.6.1

- Fully ported the Miners from https://github.com/BOLTMAGIC/VoidMiners-Reforked
- Fully ported the Solar Panels from https://github.com/BOLTMAGIC/VoidMiners-Reforked
