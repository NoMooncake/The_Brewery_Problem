## **Package: brewery.plant**

This package models the physical plant: vats and the small network of connectors.  
It includes registration and cleanliness lifecycle, plus simple transport components.

Classes in scope: `PlantRegistry`, `Vat` (abstract), `MixingVat`, `FermentingVat`, `SettlingVat`, `BottlingVat`, `Manifold`, `Pipe`, `Valve`, `Pump`.

| Class | WMC | DIT | NOC | CBO | RFC | **Design Comment** |
|:------|:---:|:---:|:---:|:---:|:---:|:--------------------|
| **PlantRegistry** | 14 | 1 | 0 | 4 | 10 | Array-backed registry; unique-ID add, linear lookup, allocate-clean-vat, mark clean/dirty, snapshot. |
| **Vat (abstract)** | 8 | 1 | 4 | 1 | 6 | Base container with id/capacity/cleanliness; minimal API; parent of stage-specific vats. |
| **MixingVat** | 2 | 2 | 0 | 1 | 2 | Thin subclass over `Vat`; no added state/logic beyond type identity. |
| **FermentingVat** | 2 | 2 | 0 | 1 | 2 | Thin subclass; reserved for stage semantics and future state transitions. |
| **SettlingVat** | 2 | 2 | 0 | 1 | 2 | Thin subclass; maintains shallow inheritance for clarity. |
| **BottlingVat** | 2 | 2 | 0 | 1 | 2 | Thin subclass; marks the bottling stage location. |
| **Manifold** | 6 | 1 | 0 | 3 | 6 | Lightweight hub for connecting pipes/valves; keeps operations small and cohesive. |
| **Pipe** | 4 | 1 | 0 | 2 | 4 | Simple connector; tiny API for attach/detach or state flags. |
| **Valve** | 4 | 1 | 0 | 2 | 4 | Binary open/close semantics; intentionally minimal. |
| **Pump** | 5 | 1 | 0 | 2 | 5 | Small transport helper; no external collections; linear control. |
| **Total (Plant)** | **49** | **14** | **4** | **18** | **43** | Totals across plant classes (registry + containers + connectors). |
| **Average (Plant)** | **4.9** | **1.4** | **0.4** | **1.8** | **4.3** | Shallow inheritance, small cohesive methods, predictable coupling centered on the registry and base `Vat`. |

### **Interpretation**
- **WMC:** Concentrated in `PlantRegistry` (registry ops) and small utilities; vat subclasses remain intentionally thin.
- **DIT / NOC:** Shallow tree with one abstract base (`Vat`) and four children (NOC=4). DIT≈2 for subclasses, 1 otherwise.
- **CBO:** Coupling clusters around the registry and base types; connectors (`Pipe/Valve/Pump`) stay low.
- **RFC:** Public surfaces are compact; responsibilities are cohesive (cleanliness lifecycle, registration, and light transport).

