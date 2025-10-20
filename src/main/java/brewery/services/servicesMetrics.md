## **Package: brewery.services**

This package represents the auxiliary service layer supporting the Brewery Problem.  
It provides monitoring, scheduling, sensor abstraction, and pathfinding utilities.

Classes in scope: `MonitoringService`, `Scheduler`, `PathFinder`, `Sensor`, `Thermometer`, `Hydrometer`.

| Class | WMC | DIT | NOC | CBO | RFC | **Design Comment** |
|:------|:---:|:---:|:---:|:---:|:---:|:--------------------|
| **MonitoringService** | 10 | 1 | 0 | 4 | 8 | Provides status snapshots and reorder threshold checks; low control flow complexity, cohesive instrumentation role. |
| **Scheduler** | 6 | 1 | 0 | 3 | 5 | Handles simulated scheduling of transfers; light orchestration wrapper around tasks. |
| **PathFinder** | 5 | 1 | 0 | 2 | 4 | Placeholder for route optimization logic; small and cohesive utility class. |
| **Sensor (abstract)** | 4 | 1 | 2 | 2 | 3 | Base abstraction for all sensor types (temperature, gravity); defines read interface. |
| **Thermometer** | 3 | 2 | 0 | 1 | 2 | Implements temperature sensor; trivial subclass maintaining low complexity. |
| **Hydrometer** | 3 | 2 | 0 | 1 | 2 | Implements gravity sensor; identical structure to `Thermometer`. |
| **Total (Services)** | **31** | **8** | **2** | **13** | **24** | Total metrics across all service-layer classes. |
| **Average (Services)** | **5.2** | **1.3** | **0.3** | **2.2** | **4.0** | Shallow inheritance, minimal coupling, and small cohesive utilities that extend service functionality across the brewery system. |

### **Interpretation**
- **WMC:** The heaviest logic lies in `MonitoringService`, which centralizes readouts and threshold checks; other services remain tiny.
- **DIT / NOC:** Slightly deeper tree (DIT≈2) from `Sensor` → `Thermometer`/`Hydrometer`; cohesive inheritance use.
- **CBO:** Moderate coupling where services interact with core subsystems (e.g., `Inventory`); otherwise low.
- **RFC:** Small public surfaces for all utility classes; methods perform single, well-defined responsibilities.
- **Overall:** The `brewery.services` package maintains simplicity and cohesion, functioning as a lightweight, loosely coupled auxiliary layer supporting monitoring and scheduling.
