#!/usr/bin/python
# ! -*- coding: utf8 -*-

import os
import sys
import lorun

RESULT_STR = [
    'Accepted',
    'Presentation Error',
    'Time Limit Exceeded',
    'Memory Limit Exceeded',
    'Wrong Answer',
    'Runtime Error',
    'Output Limit Exceeded',
    'Compile Error',
    'System Error'
]


def runone(process, in_path, out_path, user_path, time, memory):
    fin = open(in_path)
    tmp = os.path.join(user_path, 'temp.out')
    ftemp = open(tmp, 'w')
    runcfg = {
        'args': process,
        'fd_in': fin.fileno(),
        'fd_out': ftemp.fileno(),
        'timelimit': time,  # in MS
        'memorylimit': memory,  # in KB
    }
    rst = lorun.run(runcfg)
    fin.close()
    ftemp.close()
    if rst['result'] == 0:
        ftemp = open(tmp)
        fout = open(out_path)
        crst = lorun.check(fout.fileno(), ftemp.fileno())
        fout.close()
        ftemp.close()
        os.remove(tmp)
        rst['result'] = crst
    return rst


def judge(process, data_path, user_path, time, memory):
    result = {
        "max_time": 0,
        "max_memory": 0,
        "status": 8
    }
    for root, dirs, files in os.walk(data_path):
        for in_file in files:
            if in_file.endswith('.in'):
                out_file = in_file.replace('in', 'out')
                fin = os.path.join(data_path, in_file)
                fout = os.path.join(data_path, out_file)
                if os.path.isfile(fin) and os.path.isfile(fout):
                    rst = runone(process, fin, fout, user_path, time, memory)
                    if rst['result'] == 0:
                        result['status'] = 0
                        result['max_time'] = max(result['max_time'], rst['timeused'])
                        result['max_memory'] = max(result['max_memory'], rst['memoryused'])
                    else:
                        result['status'], result['max_time'], result['max_memory'] = rst['result'], 0, 0
                        print(result)
                        return
    print result


if __name__ == '__main__':
    if len(sys.argv) != 6:
        print('Usage:%s srcfile testdata_pth testdata_total'%len(sys.argv))
        exit(-1)
    judge(sys.argv[1].split("wzy"),sys.argv[2], sys.argv[3], long(sys.argv[4]), long(sys.argv[5]))
