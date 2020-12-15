from math import floor, log, exp
import sys
from scipy.special import gammaln


def compare_floats(a, b):
    return round(a, 4) == round(b, 4)


def generate_cube_root(n):
    return n / 3


def generate_floor(n):
    return log(floor(exp(n)))


def generate_factorial(n):
    return gammaln(exp(n) + 1)


def bfs(target, visited={}, queue=[]):
    if not queue:
        return ''

    while len(queue) != 0:
        node = queue.pop(0)
        n = node[0]
        visited[n] = True
        if compare_floats(n, target):
            # print(n, target)
            return node[1]

        try:
            actual = exp(n)
            if not round(actual, 4).is_integer():
                flr = generate_floor(n)
                if flr not in visited:
                    queue.append((flr, node[1] + 'f'))

            if actual >= 2.0:
                cube_root = generate_cube_root(n)
                if cube_root not in visited:
                    queue.append((cube_root, node[1] + 'r'))

                if round(actual, 4).is_integer():
                    fact = generate_factorial(n)
                    if fact not in visited:
                        queue.append((fact, node[1] + '!'))

        except OverflowError:
            cube_root = generate_cube_root(n)
            if cube_root not in visited:
                queue.append((cube_root, node[1] + 'r'))

    return 'sad'


def test():
    for i in range(1, 101):
        print(i, '->', bfs(target=log(float(i)), visited={}, queue=[(log(4.0), '4')]))


def main():
    test()


if __name__ == '__main__':
    main()