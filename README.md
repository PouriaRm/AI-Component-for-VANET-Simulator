# AI Component-VanetSim
This is an advanced version of the [VANET simulator](https://svs.informatik.uni-hamburg.de/vanet/index.html) that enables the researcher to employ different artificial intelligence approaches to solve network and supply chains problems. Initially, we tried to employ only evolutionary algorithms on this simulation to reach our research goal. Then we decided to develop this simulator and implement the AI ​​section with more features. Since the software is open source, we decided to deploy it on Github.
## Getting started
### Installation and start
First, Clone the project. Then follow the simulator installation instructions. [click here](https://svs.informatik.uni-hamburg.de/vanet/index.html#).
### How to use AI Component?
Very simple! From the menu in the Scenarios section, choose which evolutionary algorithm you want. Then select how many vehicles you preferred. The simulator randomly considers the starting and ending points of each machine. You can also enter the value of the attributes for each algorithm. For example, in the Genetic algorithm, the penalty rate and a number of generations can be determined.
### Is it enough fast?
Yes! We used parallelization techniques to reduce the time of processing. You can see an example of this parallelism in the simulation of Genetic algorithm below. 

![](https://github.com/PouriaRm/AI-Component-for-VANET-Simulator/blob/master/Recorded%20Video.gif)

Here, each machine simultaneously travels all the paths assigned to one gene.
## Future Plans
I'm thinking of improving the performance of this component as well as adding more algorithms to it. Another of my goals is to add machine learning approaches. If you have any questions or suggestions I would really love to hear.
