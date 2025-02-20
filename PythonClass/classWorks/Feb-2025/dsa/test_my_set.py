import unittest


from my_set import Set

class TestSet(unittest.TestCase):
    def setUp(self):
        self.s = Set()
        self.s1 = Set()
        self.s2 = Set()

    def test_add(self):
        self.s.add(1)
        self.s.add(2)
        self.assertEqual(self.s.size(), 2)
        self.assertTrue(self.s.contains(1))
        self.assertTrue(self.s.contains(2))

    def test_remove(self):
        self.s.add(1)
        self.s.remove(1)
        self.assertFalse(self.s.contains(1))
        self.assertEqual(self.s.size(), 0)

    def test_union(self):
        self.s1.add(1)
        self.s1.add(2)
        self.s2.add(2)
        self.s2.add(3)
        s3 = self.s1.union(self.s2)
        self.assertTrue(s3.contains(1))
        self.assertTrue(s3.contains(2))
        self.assertTrue(s3.contains(3))
        self.assertEqual(s3.size(), 3)

    def test_intersect(self):
        self.s1.add(1)
        self.s1.add(2)
        self.s2.add(2)
        self.s2.add(3)
        s3 = self.s1.intersect(self.s2)
        self.assertTrue(s3.contains(2))
        self.assertFalse(s3.contains(1))
        self.assertFalse(s3.contains(3))
        self.assertEqual(s3.size(), 1)
