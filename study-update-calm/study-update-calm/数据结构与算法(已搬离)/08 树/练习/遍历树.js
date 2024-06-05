const data = [{
        name: 'a',
        age: 1,
        children: [{
                name: 'a1',
                age: 1,
            },
            {
                name: 'a2',
                age: 1,
                children: [{
                        name: 'a21',
                        age: 1,
                    },
                    {
                        name: 'a22',
                        age: 1,
                    },
                ]
            },
        ]
    },
    {
        name: 'b',
        age: 1,
        children: [{
                name: 'b1',
                age: 1,
                children: [{
                        name: 'b11',
                        age: 1,
                    },
                    {
                        name: 'b12',
                        age: 1,
                    },
                ]
            },
            {
                name: 'b2',
                age: 1,
                children: [{
                        name: 'b22',
                        age: 1,
                    },
                    {
                        name: 'b22',
                        age: 1,
                        children: [{
                                name: 'b21',
                                age: 1,
                            },
                            {
                                name: 'b22',
                                age: 1,
                            },
                            {
                                name: 'b23',
                                age: 1,
                            },
                        ]
                    },
                ]
            },
        ]
    },
]

const resultData = [{
        name: 'a',
        age: 1,
        index: 0,
        children: [{
                name: 'a1',
                age: 1,
                index: 0,
            },
            {
                name: 'a2',
                age: 1,
                index: 1,
                children: [{
                        name: 'a21',
                        age: 1,
                        index: 0,
                    },
                    {
                        name: 'a22',
                        age: 1,
                        index: 1,
                    },
                ]
            },
        ]
    },
    {
        name: 'b',
        age: 1,
        index: 1,
        children: [{
                name: 'b1',
                age: 1,
                index: 0,
                children: [{
                        name: 'b11',
                        age: 1,
                        index: 0,
                    },
                    {
                        name: 'b12',
                        age: 1,
                        index: 1,
                    },
                ]
            },
            {
                name: 'b2',
                age: 1,
                index: 1,
                children: [{
                        name: 'b22',
                        age: 1,
                        index: 0,
                    },
                    {
                        name: 'b22',
                        age: 1,
                        index: 1,
                        children: [{
                                name: 'b21',
                                age: 1,
                                index: 0,
                            },
                            {
                                name: 'b22',
                                age: 1,
                                index: 1,
                            },
                            {
                                name: 'b23',
                                age: 1,
                                index: 2,
                            },
                        ]
                    },
                ]
            },
        ]
    }
]
let count = 0;
const main = function(data) {
    for (let i in data) {
        data[i].index = i;
        if (data[i].children) {
            count++;
            main(data[i].children);
        }
    }
}
main(data);
console.log(data);
console.log(count);