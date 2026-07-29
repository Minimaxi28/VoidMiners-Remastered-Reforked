# Changelog

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
