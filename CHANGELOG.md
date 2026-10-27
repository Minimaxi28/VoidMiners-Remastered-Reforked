# Changelog

## 1.21.1-1.6.12

- Fix crash when it isn't the player that places the Controllers

## 1.21.1-1.6.11

- Miners now require the block to be underneath the bottom Glass Panel
- Item Multipliers now take the decimal value into consideration (multipliers like 1.5 will make 2 items ~1 out of 2 times)
- Added tag c:storage_blocks/(solar_){crystal_name}_block to the compressed 3x3 blocks
- Added tag c:gems/(solar_){crystal_name} to the gems

## 1.21.1-1.6.10

- Changes to JEI tab
  - Press SHIFT to display percentages instead of weights
  - Press CTRL to display the full number when hovering over the recipe instead of the E notation one
- Added the No Laser Upgrade
  - Right-click a Miner or Solar Controller to remove the laser beam
- Miner laser beam will now stop at the block it hits if it has a recipe / the void / bedrock
- Remove CTM compat from the mod
  - [CTM](https://www.curseforge.com/minecraft/mc-mods/ctm) compat is now in a dedicated Resource Pack, [Voidminers Remastered Reforged CTM Compat](https://www.curseforge.com/minecraft/texture-packs/voidminers-remastered-reforked-ctm-compat)
- [Fusion](https://www.curseforge.com/minecraft/mc-mods/fusion-connected-textures) compat, in a dedicated Resource Pack, [Voidminers Remastered Reforged Fusion Compat](https://www.curseforge.com/minecraft/texture-packs/voidminers-remastered-reforked-fusion-compat)

## 1.21.1-1.6.9

- Remove Mango Multiblock Library Revived dependency
- Some optimization on the Solar Panels matching what was done on Miners

## 1.21.1-1.6.8

- Fix Max Storage Upgrade T2 and T3 recipes

## 1.21.1-1.6.7

- Make it so recipes can specify a blockUnderneath, a block that will need to be anywhere under the Miner Controller to be able to get the items (no default recipes use it, it's mainly for modpack makers)
  - KubeJS can also register those recipes, see the [wiki](https://github.com/Minimaxi28/VoidMiners-Remastered-Reforked/wiki#recipe-syntax)

## 1.21.1-1.6.6

- Optimization of Miners and Solars
- Changed the package name, if you are adding custom upgrade items, please see the [wiki](https://github.com/Minimaxi28/VoidMiners-Remastered-Reforked/wiki#add-custom-max-storage-upgrades)

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
