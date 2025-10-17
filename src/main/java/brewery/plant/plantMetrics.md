## **Package: brewery.plant**

This package models the physical equipment of the brewery: the vat hierarchy and the connection/network layer (manifold, pipes, valves, pumps) plus the central equipment registry.

| Class | WMC | DIT | NOC | CBO | RFC | **Design Comment** |
|:------|:---:|:---:|:---:|:---:|:---:|:--|
| **Vat** | 9 | 1 | 4 | 0 | 5 | Abstract vessel defining id/capacity/cleanliness; small, cohesive API; serves as the base of the vat hierarchy. |
| **MixingVat** | 1 | 2 | 0 | 0 | 2 | Thin specialization; constructor-only; inherits behavior from `Vat` to keep complexity minimal. |
| **FermentingVat** | 1 | 2 | 0 | 0 | 2 | Same pattern as `MixingVat`; phase-specific identity without extra logic (high cohesion). |
| **SettlingVat** | 1 | 2 | 0 | 0 | 2 | Clarification stage specialization; ready for future settling-specific rules if needed. |
| **BottlingVat** | 1 | 2 | 0 | 0 | 2 | Endpoint vessel before packaging; intentionally minimal to keep WMC low. |
| **Manifold** | 7 | 1 | 0 | 1 | 5 | Aggregates `Pipe/Valve/Pump` and exposes `connect(...)` to assemble routes; path computation remains in `PathFinder` (good separation). |
| **Pipe** | 4 | 1 | 0 | 0 | 3 | Simple cleanliness state; tiny, focused API; no external calls. |
| **Valve** | 4 | 1 | 0 | 0 | 3 | Open/close control; mirrors `Pipe` in size and responsibility. |
| **Pump** | 4 | 1 | 0 | 0 | 3 | Start/stop control; symmetric to `Valve`/`Pipe`; highly cohesive. |
| **PlantRegistry** | 5 | 1 | 0 | 3 | 5 | Central vat lookup (`add/get`); light coupling to collection/exception utilities; compact interface. |
| **Average (Plant)** | **3.7** | **1.4** | **0.4** | **0.4** | **3.2** | Shallow inheritance, tiny cohesive classes, and very low coupling across the equipment layer. |

> **How numbers were obtained (current code state):**
> - **WMC** ≈ attributes count + statements with `;` inside methods/constructors.
> - **DIT**: `Vat` subclasses → 2 (Object → Vat → Subclass); others → 1.
> - **NOC**: `Vat` has 4 direct children; others 0.
> - **CBO**: counts methods that rely on other objects (inheritance not counted).
> - **RFC**: public methods in the class + times it calls external methods (e.g., `super(...)` in subclass ctors counted as one external call).

### **Interpretation**
- **Low WMC:** Small, single-purpose classes keep complexity low and behavior isolated.
- **Shallow DIT:** A single abstract base (`Vat`) with thin specializations improves clarity and reduces inheritance risks.
- **NOC Concentration:** `Vat` is the clear extension point; other classes remain implementation-focused.
- **Very Low CBO:** The plant layer is largely self-contained; `PlantRegistry`/`Manifold` have minimal, justified coupling.
- **Small RFC:** Compact public surfaces make the equipment layer easy to test and reason about.

**Overall:** The plant layer exhibits **high cohesion and low coupling** with an **intentional, shallow hierarchy**, supporting easy extension (e.g., adding a `CoolingVat`) without ripple effects.